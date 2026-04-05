public class Aims {
    public static void main(String[] agrs){
        Cart anOrder = new Cart();

        DigitalVideoDisc dv1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers",87, 19.95f);
        anOrder.addDigitalVideoDisc(dv1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        anOrder.printCart();
        anOrder.removeDigitalVideoDisc(dv1);
        anOrder.printCart();
    }
}