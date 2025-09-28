package src;

public class ReportFactory {

    public static Report createReport(String type) {
        if (type == null || type.isBlank())
            throw new IllegalArgumentException("Report type cannot be null or blank");

        return switch (type.trim().toLowerCase()) {
            case "basic" -> new BasicReport();
            case "summary" -> new SummaryReport();
            case "detailed" -> new DetailedReport();
            default -> throw new IllegalArgumentException("Unknown report type: " + type);
        };
    }
}
