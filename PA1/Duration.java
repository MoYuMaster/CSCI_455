public class Duration {
    private int totMinutes;
    public Duration(int hours , int minutes){
        this.totMinutes = hours*60 + minutes;

    }

    public Duration(int totalMinutes){
        this.totMinutes = totalMinutes;
    }

    public  void increase(int hours,int minutes){
        totMinutes = totMinutes + hours*60 + minutes;
    }

    public Duration add(Duration b){
        totMinutes = totMinutes + b.totMinutes;
        return this;
    }

    public String toString(){
        int hr = totMinutes/60;
        int min = totMinutes%60 ;
        String result = hr + "hrs "+min +"min";
        return result;
    }
}
