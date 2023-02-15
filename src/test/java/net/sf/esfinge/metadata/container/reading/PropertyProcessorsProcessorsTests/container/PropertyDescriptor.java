package net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container
        ;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.PropertyProcessors;
import net.sf.esfinge.metadata.container.ContainerTarget;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.DelegateReader;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.Processors.ProcessorTest;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.Processors.RegularProcessor;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.annotations.Associate;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.annotations.CollectionTest;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.annotations.DeepTest;
import net.sf.esfinge.metadata.locate.conventions.annotations.Verifier;

import java.util.List;

@ContainerFor(ContainerTarget.ALL)
public class PropertyDescriptor {

    @ElementName
    private String name;

    @PropertyProcessors(DelegateReader.class)
    private List<ProcessorTest> processorNew;


    private ProcessorTest processor;

    private boolean deepComparison;

    private boolean collectionComparison;

    @Associate({CollectionTest.class, DeepTest.class})
    private Class associateType;



    public ProcessorTest getProcessor() {
        if(processor == null)
            processor = new RegularProcessor();
        return processor;
    }
    public void setProcessor(ProcessorTest processor) {
        this.processor = processor;
    }

    public void setProcessorNew(List<ProcessorTest> processorNew) {
        this.processorNew = processorNew;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isDeepComparison() {
        return deepComparison;
    }
    public void setDeepComparison(boolean deep) {
        this.deepComparison = deep;
    }
    public boolean isCollectionComparison() {
        return collectionComparison;
    }
    public void setCollectionComparison(boolean listComparison) {
        this.collectionComparison = listComparison;
    }
    public Class getAssociateType() {
        return associateType;
    }
    public void setAssociateType(Class type) {
        this.associateType = type;
    }
    public List<ProcessorTest> getProcessorNew() {
        return processorNew;
    }
    public void addProcessorNew(ProcessorTest processorNew) {
        this.processorNew.add(processorNew);
    }
}
