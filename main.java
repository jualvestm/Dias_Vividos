import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o dia de Nascimento: ");
        int diaNascim = scanner.nextInt();
        System.out.println("Diga o mês do nascimento: ");
        int mesNascim = scanner.nextInt();
        System.out.println("Agora informe o ano do nascimento: ");
        int anoNascim = scanner.nextInt();
        LocalDate hoje = LocalDate.now();
        int diasVividos = calcularDiasVividos(diaNascim, mesNascim, anoNascim, hoje);
        System.out.println("Você viveu " + diasVividos + " dias até hoje");
    }

    public static int calcularDiasVividos(int dia, int mes, int ano, LocalDate hoje) {
        LocalDate dataNascim = LocalDate.of(ano, mes, dia);
        int diasVividos = 0;
        diasVividos += DiasPassadosAno(dia, mes, ano);
        for (int i = ano + 1; i < hoje.getYear(); i++) {
            diasVividos += YearMonth.of(i, 12).lengthOfYear();
        }
        diasVividos += DiasPassadosAno(hoje.getDayOfMonth(), hoje.getMonthValue(), hoje.getYear());
        return diasVividos;
    }

    public static int DiasPassadosAno(int dia, int mes, int ano) {
        LocalDate data = LocalDate.of(ano, mes, dia);
        LocalDate inicioAno = LocalDate.of(ano, 1, 1);
        return (int) java.time.temporal.ChronoUnit.DAYS.between(inicioAno, data);
    }
}
