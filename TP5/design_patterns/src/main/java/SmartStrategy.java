public class SmartStrategy implements OrderingStrategy {
    boolean placeOrder = false;
    boolean inQueue = false;
    StringDrink drink;
    StringRecipe recipe;
    StringBar bar;

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (placeOrder || bar.isHappyHour()) {
            bar.order(drink, recipe);
        }
        else { this.drink = drink; this.recipe = recipe; this.bar = bar; this.inQueue = true; }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        placeOrder = true;
        if (inQueue) { this.wants(this.drink, this.recipe, this.bar); inQueue = false; }
    }

    @Override
    public void happyHourEnded(StringBar bar) {
        placeOrder = false;
    }
}
