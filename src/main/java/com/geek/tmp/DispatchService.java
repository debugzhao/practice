//package com.geek.tmp;
//
///**
// * @Author zhaojingchao
// * @Date 2024/06/07 08:50
// * @Email zhaojingchao@joysuch.com
// * @Desc
// */
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.Duration;
//import java.util.*;
//import java.util.stream.Collectors;
//
//enum TouState {
//    谷, 峰, 尖
//}
//
//public class DispatchService {
//
//    public List<DispatchCommand> dispatch(TouDTO touDTO) {
//        List<DispatchCommand> commands = new ArrayList<>();
//
//        Set<TouPeriodDTO> periods = touDTO.getPeriods();
//        Set<TouPriceDTO> prices = touDTO.getPrices();
//
//        // 将电价映射到各个时段
//        Map<TouState, BigDecimal> stateToPrice = prices.stream()
//                .collect(Collectors.toMap(TouPriceDTO::getState, TouPriceDTO::getPrice));
//
//        // 将时段按开始时间排序
//        List<TouPeriodDTO> sortedPeriods = periods.stream()
//                .sorted(Comparator.comparing(TouPeriodDTO::getStartTime))
//                .collect(Collectors.toList());
//
//        double currentCapacity = 0.0; // 当前电量
//        final double capacity = 100.0; // 电池容量
//        final double power = 50.0; // 标准功率
//
//        // 遍历时段并生成充放电指令
//        for (TouPeriodDTO period : sortedPeriods) {
//            BigDecimal currentPrice = stateToPrice.get(period.getState());
//            double availableHours = (double) Duration.between(period.getStartTime(), period.getEndTime()).toMinutes() / 60;
//
//            // 充电逻辑：在谷时段充电
//            if (period.getState() == TouState.谷 && currentCapacity < capacity) {
//                double hoursToCharge = Math.min(availableHours, (capacity - currentCapacity) / power);
//                if (hoursToCharge > 0) {
//                    LocalTime endTime = period.getStartTime().plusMinutes((long) (hoursToCharge * 60));
//                    commands.add(new DispatchCommand(period.getStartTime(), endTime, power));
//                    currentCapacity += hoursToCharge * power;
//                }
//            }
//
//            // 放电逻辑：在峰或尖时段放电
//            if ((period.getState() == TouState.峰 || period.getState() == TouState.尖) && currentCapacity > 0) {
//                double hoursToDischarge = Math.min(availableHours, currentCapacity / power);
//                if (hoursToDischarge > 0) {
//                    LocalTime endTime = period.getStartTime().plusMinutes((long) (hoursToDischarge * 60));
//                    commands.add(new DispatchCommand(period.getStartTime(), endTime, -power));
//                    currentCapacity -= hoursToDischarge * power;
//                }
//            }
//        }
//
//        return commands;
//    }
//
//    public static void main(String[] args) {
//        Set<TouPeriodDTO> periods = new HashSet<>(Arrays.asList(
//                new TouPeriodDTO(TouState.谷, LocalTime.of(0, 0), LocalTime.of(8, 0)),
//                new TouPeriodDTO(TouState.峰, LocalTime.of(8, 0), LocalTime.of(9, 0)),
//                new TouPeriodDTO(TouState.尖, LocalTime.of(9, 0), LocalTime.of(11, 0)),
//                new TouPeriodDTO(TouState.谷, LocalTime.of(11, 0), LocalTime.of(13, 0)),
//                new TouPeriodDTO(TouState.峰, LocalTime.of(13, 0), LocalTime.of(15, 0)),
//                new TouPeriodDTO(TouState.尖, LocalTime.of(15, 0), LocalTime.of(17, 0)),
//                new TouPeriodDTO(TouState.峰, LocalTime.of(17, 0), LocalTime.of(22, 0)),
//                new TouPeriodDTO(TouState.谷, LocalTime.of(22, 0), LocalTime.of(0, 0))
//        ));
//
//        Set<TouPriceDTO> prices = new HashSet<>(Arrays.asList(
//                new TouPriceDTO(TouState.谷, new BigDecimal("0.31")),
//                new TouPriceDTO(TouState.峰, new BigDecimal("0.92")),
//                new TouPriceDTO(TouState.尖, new BigDecimal("1.20"))
//        ));
//
//        TouDTO touDTO = new TouDTO(LocalDate.now(), periods, prices);
//
//        DispatchService service = new DispatchService();
//        List<DispatchCommand> commands = service.dispatch(touDTO);
//
//        for (DispatchCommand command : commands) {
//            System.out.println(command);
//        }
//    }
//}
//
//class TouPeriodDTO {
//    private TouState state;
//    private LocalTime startTime;
//    private LocalTime endTime;
//
//    public TouPeriodDTO(TouState state, LocalTime startTime, LocalTime endTime) {
//        this.state = state;
//        this.startTime = startTime;
//        this.endTime = endTime;
//    }
//
//    public TouState getState() {
//        return state;
//    }
//
//    public LocalTime getStartTime() {
//        return startTime;
//    }
//
//    public LocalTime getEndTime() {
//        return endTime;
//    }
//
//    public int durationInMinutes() {
//        return endTime.isAfter(startTime) ? (int) java.time.Duration.between(startTime, endTime).toMinutes()
//                : (int) java.time.Duration.between(startTime, endTime.plusHours(24)).toMinutes();
//    }
//}
//
//class TouPriceDTO {
//    private TouState state;
//    private BigDecimal price;
//
//    public TouPriceDTO(TouState state, BigDecimal price) {
//        this.state = state;
//        this.price = price;
//    }
//
//    public TouState getState() {
//        return state;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//}
//
//class TouDTO {
//    private LocalDate date;
//    private Set<TouPeriodDTO> periods;
//    private Set<TouPriceDTO> prices;
//
//    public TouDTO(LocalDate date, Set<TouPeriodDTO> periods, Set<TouPriceDTO> prices) {
//        this.date = date;
//        this.periods = periods;
//        this.prices = prices;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public Set<TouPeriodDTO> getPeriods() {
//        return periods;
//    }
//
//    public Set<TouPriceDTO> getPrices() {
//        return prices;
//    }
//}
//
//class DispatchCommand {
//    private LocalTime startTime;
//    private LocalTime endTime;
//    private Double power;
//
//    public DispatchCommand(LocalTime startTime, LocalTime endTime, Double power) {
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.power = power;
//    }
//
//    public LocalTime getStartTime() {
//        return startTime;
//    }
//
//    public LocalTime getEndTime() {
//        return endTime;
//    }
//
//    public Double getPower() {
//        return power;
//    }
//
//    @Override
//    public String toString() {
//        return "DispatchCommand{" +
//                "startTime=" + startTime +
//                ", endTime=" + endTime +
//                ", power=" + power +
//                '}';
//    }
//}
