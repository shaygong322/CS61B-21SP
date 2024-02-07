package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        for(int n = 1000; n <= 128000; n *= 2){
            SLList<Integer> tmp = new SLList<>();
            for(int i = 1; i <= n; i++){
                tmp.addLast(i);
            }
            int m = 10000;
            opCounts.addLast(m);
            Stopwatch sw = new Stopwatch();
            for(int j = 0; j < m; j++){
                tmp.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            ns.addLast(n);
            times.addLast(timeInSeconds);
        }
        printTimingTable(ns, times, opCounts);
    }

}
