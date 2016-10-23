/*
 * *************************************************************************
 *
 * Copyright:       Robert Bosch GmbH, 2016
 *
 * *************************************************************************
 */

/**
 * Dear "developer", please document your class RIGHT HERE!.
 */

package info.novatec.testit.livingdoc.training.exercises.lifecycle;

import info.novatec.testit.livingdoc.reflect.AfterRow;
import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.BeforeRow;
import info.novatec.testit.livingdoc.reflect.BeforeTable;
import info.novatec.testit.livingdoc.reflect.annotation.Alias;
import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;

@FixtureClass("Decision Table Life Cycle")
public class DecisionTableLifeCycleFixture {

    private Integer valueOfA;

    @BeforeTable
    public void beforeTable() {
        System.out.println("beforeTable");
    }

    @BeforeRow
    public void beforeRow() {
        System.out.println("beforeRow");
    }

    @AfterRow
    public void afterRow() {
        System.out.println("afterRow");
        valueOfA = null;
    }

    @AfterTable
    public void afterTable() {
        System.out.println("afterTable");
    }

    @Alias("A")
    public void setA(Integer value){
        System.out.println("set A: " + value);
        valueOfA = value;
    }

    @Alias("B")
    public Integer getB(){
        Integer result = -valueOfA;
        System.out.println("get B: " + result);
        return result;
    }


}
