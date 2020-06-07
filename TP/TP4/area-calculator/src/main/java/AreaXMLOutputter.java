public class AreaXMLOutputter {
    SumProvider aggregator;

    public AreaXMLOutputter(SumProvider aggregator) {
        this.aggregator = aggregator;
    }

    public String output() {
        return "<area>" + aggregator.sum() + "</area>";
    }
}
