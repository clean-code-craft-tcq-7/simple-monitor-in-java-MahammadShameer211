package vitals;

public abstract class VitalsChecker {

  public static boolean vitalsOk(float temperature, float pulseRate, float spo2) throws InterruptedException {
    boolean tempOk = checkVital(temperature, 95, 102, "Temperature is critical!");
    boolean pulseOk = checkVital(pulseRate, 60, 100, "Pulse Rate is out of range!");
    boolean spo2Ok = checkVital(spo2, 90, Float.MAX_VALUE, "Oxygen Saturation out of range!");

    return tempOk && pulseOk && spo2Ok;
  }

  private static boolean checkVital(float value, float min, float max, String alertMsg) throws InterruptedException {
    if (value < min || value > max) {
      System.out.println(alertMsg);
      showAlertAnimation();
      return false;
    }
    return true;
  }

  private static void showAlertAnimation() throws InterruptedException {
    for (int i = 0; i < 6; i++) {
      System.out.print("\r* ");
      Thread.sleep(1000);
      System.out.print("\r *");
      Thread.sleep(1000);
    }
    System.out.println();
  }
}
