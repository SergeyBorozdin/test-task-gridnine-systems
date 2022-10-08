import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Factory class to get sample list of flights.
 */
class FlightBuilder {
    static List<Flight> createFlights() { // создает лист обьектов локалдатетайм с датами вылета и прилета
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        return Arrays.asList(
            //A normal flight with two hour duration
            createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
            //A normal multi segment flight
            createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
            //A flight departing in the past
            createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
            //A flight that departs before it arrives
            createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
            //A flight with more than two hours ground time
            createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
            //Another flight with more than two hours ground time
            createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
    }

    private static Flight createFlight(final LocalDateTime... dates) { // принимает массив локалдатетайм
        if ((dates.length % 2) != 0) { // проверка что есть вылет и прилет, иначе обрабатывает эксепшн
            throw new IllegalArgumentException(
                "you must pass an even number of dates");
        }
        List<Segment> segments = new ArrayList<>(dates.length / 2); // создает массив сегментов ограничивает емкость в половину длинны принятого массива
        for (int i = 0; i < (dates.length - 1); i += 2) { // цикл по длинне массива локалдатетайм с шагом через 1
            segments.add(new Segment(dates[i], dates[i + 1])); // запись в новый массив сегмента даты и время вылет-прилет
        }
        return new Flight(segments); // возращает обьект флайдж, передает в него лист сегментов
    }
}

/**
 * Bean that represents a flight.
 */
class Flight {
    private final List<Segment> segments;

    Flight(final List<Segment> segs) { // получает в конструктор массив сегментов
        segments = segs; // сохранияет из конструктора переданный в свой массив
    }

    List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString) // использует стрим, мап преобразует в строку каждый сегмент
            .collect(Collectors.joining(" ")); // и джойнит пробелом сегменты
    }
}

/**
 * Bean that represents a flight segment.
 */
class Segment {
    private final LocalDateTime departureDate;

    private final LocalDateTime arrivalDate;

    Segment(final LocalDateTime dep, final LocalDateTime arr) { // в конструкторе присваивает своим переменным значения вылета прилета
        departureDate = Objects.requireNonNull(dep); // проверяет не равно ли значение null
        arrivalDate = Objects.requireNonNull(arr); // позволяет выбрасыывать исключения или лог
    }

    LocalDateTime getDepartureDate() {
        return departureDate;
    }

    LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
            + ']';
    }
}