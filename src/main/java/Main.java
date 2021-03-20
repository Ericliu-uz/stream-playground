import countries.Country;
import countries.CountryRepository;
import countries.Region;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Country> countries = new CountryRepository().getAll();
        //exercise7(countries);
        //System.out.println((exercise3_3(countries)));

        //System.out.println(exercise2_1(countries));
        //System.out.println(exercise2_2(countries));
        //exercise2_3(countries);
        //exercise2_4(countries);
        //exercise2_5(countries);
        //System.out.println(exercise2_6(countries));
        //exercise2_7(countries);
        //exercise2_8(countries);
        //System.out.println(exercise2_9(countries));
        //exercise2_10(countries);
        //exercise2_11(countries);
        //System.out.println(exercise2_12(countries));
        //exercise2_13(countries);
        //System.out.println(exercise2_14(countries));
        //exercise2_15(countries);
        //exercise2_16(countries);
    }

    public static void exercise7(List<Country> countries) {
        countries.stream()
                .filter(country -> country.getRegion() == Region.EUROPE)
                .map(country -> country.getName())
                .forEach(System.out::println);
    }

    public static long exercise8(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.getRegion() == Region.EUROPE)
                .count();
    }

    public static void exercise9(List<Country> countries) {
        countries.stream()
                .filter(country -> country.getPopulation() < 100)
                .forEach(System.out::println);
    }

    public static void exercise10(List<Country> countries) {
        countries.stream()
                .filter(country -> country.getPopulation() < 100)
                .map(country -> country.getName())
                .forEach(System.out::println);
    }

    public static long exercise11(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.getRegion() == Region.EUROPE)
                .mapToLong(country -> country.getPopulation())
                .sum();
    }

    public static void exercise12(List<Country> countries) {
        countries.stream()
                .filter(country -> country.getRegion() == Region.EUROPE)
                .map(country -> country.getPopulation())
                .sorted()
                .forEach(System.out::println);
    }

    public static void exercise13(List<Country> countries) {
        countries.stream()
                .filter(country -> country.getRegion() == Region.EUROPE)
                .map(country -> country.getPopulation())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    public static Country exercise14(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.getRegion() == Region.EUROPE)
                .max(Comparator.comparingLong(Country::getPopulation))
                .get();
    }

    public static boolean exercise17(List<Country> countries) {
        return countries.stream()
                .anyMatch(country -> country.getPopulation() == 0);
    }

    public static Country exercise19(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.getName().startsWith("H"))
                .findFirst()
                .get();
    }

    public static long exercise20(List<Country> countries) {
        return countries.stream()
                .flatMap(country -> country.getTimezones().stream())
                .distinct()
                .count();
    }

    public static Country exercise3_1(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.getArea() != null)
                .max(Comparator.comparing(Country::getArea))
                .get();
    }

    public static void exercise3_2(List<Country> countries) {
        countries.stream()
                .filter(country -> country.getArea() == null)
                .map(country -> country.getName())
                .forEach(System.out::println);
    }

    public static DoubleSummaryStatistics exercise3_3(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.getArea() != null)
                .mapToDouble(country -> country.getArea().doubleValue())
                .summaryStatistics();
    }

    public static double exercise3_4(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.getArea() != null)
                .mapToDouble(country -> country.getArea().doubleValue())
                .sum();
    }

    public static String exercise3_5(List<Country> countries) {
        return countries.stream()
                .map(country -> country.getName())
                .sorted()
                .reduce("", (string1, string2) -> string1 + "," + string2);
    }


    /*********************************************************************************/

    public static boolean exercise2_1(List<Country> countries) {
        return countries.stream()
                        .anyMatch(country -> country.getName().toLowerCase().contains("island"));
    }

    public static String exercise2_2(List<Country> countries) {
        return countries.stream()
                        .filter(country -> country.getName().toLowerCase().contains("island"))
                        .findFirst()
                        .get()
                        .getName();
    }

    public static void exercise2_3(List<Country> countries) {
        countries.stream()
                 .filter(country -> country.getName().toLowerCase().charAt(0) == country.getName().charAt(country.getName().length() - 1))
                 .map(country -> country.getName())
                 .forEach(System.out::println);
    }

    public static void exercise2_4(List<Country> countries) {
        countries.stream()
                 .mapToLong(country -> country.getPopulation())
                 .sorted()
                 .limit(10)
                 .forEach(System.out::println);
    }

    public static void exercise2_5(List<Country> countries) {
        countries.stream()
                 .map(country -> country.getName())
                 .sorted()
                 .limit(10)
                 .forEach(System.out::println);
    }

    public static IntSummaryStatistics exercise2_6(List<Country> countries) {
        return countries.stream()
                      //.filter(country -> country.getTranslations() != null)
                        .mapToInt(country -> country.getTranslations().size())
                        .summaryStatistics();
    }

    public static void exercise2_7(List<Country> countries) {
        countries.stream()
                 .sorted(Comparator.comparing(country -> country.getTimezones().size()))
                 .forEach(country -> System.out.println(country.getName()));
    }

    public static void exercise2_8(List<Country> countries) {
        countries.stream()
                 .sorted(Comparator.comparing(country -> country.getTimezones().size()))
                 .forEach(country -> System.out.println(country.getName() + "_:_" + country.getTimezones().stream().count()));
    }

  public static long exercise2_9(List<Country> countries) {
        return countries.stream()
                        .filter(country -> !country.getTranslations().containsKey("es"))
                        .count();
   }

    public static void exercise2_10(List<Country> countries) {
        countries.stream()
                 .filter(country -> country.getArea() == null)
                 .map(country -> country.getName())
                 .forEach(System.out::println);
    }

    public static void exercise2_11(List<Country> countries) {
            countries.stream()
                     .flatMap(country -> country.getTranslations().keySet().stream())
                     .distinct()
                     .sorted()
                     .forEach(System.out::println);
    }

    public static OptionalDouble exercise2_12(List<Country> countries) {
        return countries.stream()
                        .mapToDouble(country -> country.getName().length())
                        .average();
    }

    public static void exercise2_13(List<Country> countries) {
        countries.stream()
                 .filter(country -> country.getArea() == null)
                 .map(country -> country.getRegion())
                 .distinct()
                 .forEach(System.out::println);
    }

    public static Country exercise2_14(List<Country> countries) {
        return countries.stream()
                        .filter(country -> country.getArea() != null)
                        .max(Comparator.comparing(Country::getArea))
                        .get();
    }

    public static void exercise2_15(List<Country> countries) {
        countries.stream()
                 .filter(country -> country.getArea() != null && country.getArea().compareTo(BigDecimal.ONE) < 0)
                 .map(country -> country.getName())
                 .forEach(System.out::println);
    }

    public static void exercise2_16(List<Country> countries) {
        countries.stream()
                .filter(country -> country.getRegion() == Region.EUROPE || country.getRegion() == Region.ASIA)
                .flatMap(country -> country.getTimezones().stream())
                .distinct()
                .forEach(System.out::println);
    }

}
