public class StringCaseChanger implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        StringBuffer stringBuffer = new StringBuffer(drink.getText());
        for (int i = 0; i < stringBuffer.length(); i++) {
            char ch = stringBuffer.charAt(i);
            if (Character.isLowerCase(ch)) {
                stringBuffer.setCharAt(i, Character.toUpperCase(ch));
            } else {
                stringBuffer.setCharAt(i, Character.toLowerCase(ch));
            }
        }
        drink.setText(stringBuffer.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
