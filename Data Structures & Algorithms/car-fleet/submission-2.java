class Solution {
    private class Car {
        int position;
        int speed;
        double time;

        Car(int position, int speed, double time) {
            this.position = position;
            this.speed = speed;
            this.time = time;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < speed.length; i++) {
            cars.add(new Car(position[i],speed[i],getTime(target-position[i],speed[i])));
        }

        Collections.sort(cars, (b,a) -> b.position-a.position);

        for(int i = 0; i < cars.size(); i++) {

            Car car = cars.get(i);
            double time = car.time;
            while(!stack.isEmpty() && stack.peek() <= time) {
                stack.pop();
            }
            stack.add(time);
        }

        return stack.size();
    }

    private double getTime(int distance, int speed) {
        return (double)distance/speed;
    }
}
