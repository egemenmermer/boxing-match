public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeihth;

    public Match(Fighter f1, Fighter f2, int minWeight, int maxWeihth){
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeihth = maxWeihth;
    }

    public void run(){
        if (checkWeight()){
            while (f1.health > 0 && f2.health > 0){
                System.out.println("======== YENİ ROUND ===========");

                if (checkWho()){
                    f2.health = f1.hit(f2);

                    if(isWin()){
                        break;
                    }

                }else {
                    f1.health = f2.hit(f1);

                    if(isWin()){
                        break;
                    }
                }

                printScore();
            }
        }
    }

    public boolean checkWeight(){
        return (f1.weight >= minWeight && f1.weight < maxWeihth) && (f2.weight >= minWeight && f2.weight <= maxWeihth);
    }

    public boolean isWin(){
        if(f1.health == 0){
            System.out.println("Maçı Kazanan : " + f2.name);
            return true;
        }
        if(f2.health == 0){
            System.out.println("Maçı Kazanan : " + f1.name);
            return true;
        }
        return false;
    }
    public boolean checkWho(){
        double randomValue = Math.random() * 100;
        if (randomValue > 50){
            return true;
        }else {
            return false;
        }
    }
    private void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Kalan Can \t:" + f1.health);
        System.out.println(f2.name + " Kalan Can \t:" + f2.health);
    }
}
