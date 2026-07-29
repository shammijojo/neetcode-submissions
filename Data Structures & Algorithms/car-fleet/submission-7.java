class Solution {
    class Car {
            int speed;
            int position;
            double timeTaken;

            Car(int speed, int position, double timeTaken) {
                this.speed = speed;
                this.position = position;
                this.timeTaken = timeTaken;
            }
        }
    public int carFleet(int target, int[] position, int[] speed) {

        List<Car> cars = new ArrayList<>();
        
        for(int i = 0; i < speed.length; i++) {
            double timeTaken = (double)(target-position[i])/speed[i];
            cars.add(new Car(speed[i],position[i],timeTaken));
        }

        Collections.sort(cars, (a,b) -> b.position-a.position);

        for(int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).timeTaken);
        }

        int fleet = speed.length;
        for(int i = 1; i < cars.size(); i++) {
            if(cars.get(i).timeTaken <= cars.get(i-1).timeTaken) {
                cars.get(i).timeTaken = cars.get(i-1).timeTaken;
                fleet--;
            }
        }

        return fleet;


    }
}
