import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();
        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        Square s1 = new Square(2);
        Square s2 = new Square(1.2);
        Circle c1 = new Circle(5);
        Ellipse e1 = new Ellipse(2, 3);
        Rectangle r1 = new Rectangle(2, 3);
        Triangle t1 = new Triangle(2,2);
        Line l1 = new Line(23);

        House h1 = new House(230);
        House h2 = new House(100);
        House h3 = new House(400);
        House h4 = new House(60);

        List<House> houses = new ArrayList<>();
        houses.add(h2);
        houses.add(h3);
        houses.add(h4);
        City city = new City(houses);
        AreaStringOutputter cityString = new AreaStringOutputter(city);
        AreaXMLOutputter cityXML = new AreaXMLOutputter(city);

        aggregator.addShape(s1);
        aggregator.addShape(s2);
        aggregator.addShape(c1);
        aggregator.addShape(e1);
        aggregator.addShape(r1);
        aggregator.addShape(t1);

        aggregator.addShape(h1);

        t1.draw();
        l1.draw();

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
        System.out.println();
        System.out.println(cityString.output());
        System.out.println(cityXML.output());
    }
}
