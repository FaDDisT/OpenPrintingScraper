package it.mankey.openprintingscraper.domain

    import static it.mankey.openprintingscraper.domain.Fixtures.MANIFACTURER_NAME
import static it.mankey.openprintingscraper.domain.TestUtils.isValidJson
import static org.apache.commons.lang.StringUtils.isBlank

class ManufacturerTest extends spock.lang.Specification {

    def "create should return an object with given name"() {
        when:
        def manufacturer = Manufacturer.create(MANIFACTURER_NAME)

        then:
        manufacturer.getName() == MANIFACTURER_NAME
    }

    def "create throws an IllegalArgumentException when a blank, null or empty name is provided"() {
        when:
        Manufacturer.create(name)

        then:
        thrown(IllegalArgumentException)

        where:
        name << ["\n", " ", "\t", "", null]
    }

    def "canCreate should be false for blank, empty, and null strings"() {
        expect:
        !Manufacturer.canCreate(name)

        where:
        name << ["\n", " ", "\t", "", null]
    }

    def "equals is properly implemented"() {
        def thisTwinManufacturer = Manufacturer.create(Fixtures.MANIFACTURER_NAME)
        def thatTwinManufacturer = Manufacturer.create(Fixtures.MANIFACTURER_NAME)
        def otherManufacturer = Manufacturer.create(Fixtures.MANIFACTURER_NAME + " DIFFERENCE")

        expect:
        thisTwinManufacturer.equals(thatTwinManufacturer)
        thisTwinManufacturer.equals(thisTwinManufacturer)
        !thisTwinManufacturer.equals(otherManufacturer)
        !thisTwinManufacturer.equals(null)
        !thisTwinManufacturer.equals(new Object())
    }

    def "hashCode is properly implemented"() {
        def thisManufacturer = Manufacturer.create(Fixtures.MANIFACTURER_NAME)
        def thatManufacturer = Manufacturer.create(Fixtures.MANIFACTURER_NAME)

        expect:
        thisManufacturer.hashCode() == thatManufacturer.hashCode()
    }

    def "toString returns a valid JSON representation of the object"() {
        when:
        def thisManufacturer = Manufacturer.create(Fixtures.MANIFACTURER_NAME);
        def manifacturer = thisManufacturer.toString();

        then:
        !isBlank(manifacturer)
        isValidJson(manifacturer);
    }
}
