void main() {
    SmoothieCard crystal = new SmoothieCard("Crystal", 300);
    SmoothieCard sophie = new SmoothieCard("Sophia", 500);

    crystal.addFruit(1);
    crystal.addProtein();
    crystal.addTopping("M&Ms");
    crystal.addTopping("gummy bears");

    IO.println(crystal.sendOrder());
    IO.println(crystal.sendOrder());
    IO.println(sophie.sendOrder());
}
