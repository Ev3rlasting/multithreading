package DeepCopy;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class DeepCopyTest {

    @Test
    public void testShallowCopy() {
        AddressDto address = new AddressDto("Downing St 10", "London", "England");
        UserDto pm = new UserDto("Prime", "Minister", address);

        UserDto shallowCopy = new UserDto(pm.getFirstName(), pm.getLastName(), pm.getAddress());

        //assertSame(shallowCopy, pm);
        
//        pm.setFirstName("James");
//        pm.setAddress(new AddressDto("Piccadilly", "London", "UK"));
        address.setStreet("Piccadilly");

        assertSame(shallowCopy, pm);
    }
}