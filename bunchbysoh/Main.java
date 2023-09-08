package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    int n = presentCapacities.length; // length of the array
    int SoH[]=new int[n];
    //iterating over the given present capacitites for calculating SoH and classifying batteries
    for(int i=0;i<n;i++)                            
    {
        SoH[i]=100*presentCapacities[i]/120;   //assuming 120Ah as rated capacity
        if(SoH[i]>80)
        {
            counts.healthy++;
            
        }
        else if(SoH[i]<=80 && SoH[i]>=65)
        {
            counts.exchange++;
        }
        else{
            counts.failed++;
        }
    }
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {115,118, 80, 95, 91, 77};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    assert(counts.healthy+counts.exchange+counts.failed==presentCapacities.length);
    //printing number of batteries of each type
    System.out.println("Number of healthy batteries: "+counts.healthy);
    System.out.println("Number of exchange batteries: "+counts.exchange);
    System.out.println("Number of failed batteries: "+counts.failed);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
