public class StringReplacer implements StringTransformer {
    char char_old, char_new;

    public StringReplacer(char char_old, char char_new) {
        this.char_old = char_old;
        this.char_new = char_new;
    }

    @Override
    public void execute(StringDrink drink) {
        String temp = drink.getText();
        temp = temp.replace(char_old, char_new);
        drink.setText(temp);
    }

    @Override
    public void undo(StringDrink drink) {
        String temp = drink.getText();
        temp = temp.replace(char_new, char_old);
        drink.setText(temp);
    }
}
