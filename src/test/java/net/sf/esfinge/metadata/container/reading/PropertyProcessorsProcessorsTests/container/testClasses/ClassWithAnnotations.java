package net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.testClasses;

import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.annotations.DeepTest;

public class ClassWithAnnotations {
    public int num;

    @DeepTest
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
