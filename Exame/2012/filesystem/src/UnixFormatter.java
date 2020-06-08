public class UnixFormatter implements NameFormatter {
    char separator = '/';

    @Override
    public char getSeparator() {
        return separator;
    }
}
