package test.lom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
class Dog {
    private String name;
    private int age;
}

public class LomTest {
    public static void main(String[] args) {
        Dog d1 = new Dog("강아지", 3);
        d1.setAge(4);
        d1.getName();
    }

}
