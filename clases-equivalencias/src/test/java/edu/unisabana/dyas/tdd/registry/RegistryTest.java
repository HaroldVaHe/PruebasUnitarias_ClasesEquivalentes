package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person Person = new Person("John Doe", 1234567, 25,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(Person);
        Assert.assertEquals(RegisterResult.VALID, result);
        Person Persona = new Person("Jana Dawn", 7654321, 50,Gender.FEMALE,true);
        RegisterResult resultado = registry.registerVoter(Persona);
        Assert.assertEquals(RegisterResult.VALID, resultado);

        Person Person2 = new Person("David", 1234567, 25,Gender.MALE,true);
        RegisterResult resultDuplicated = registry.registerVoter(Person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, resultDuplicated);

        Person Person3 = new Person("DavidLO", 12345678, 25,Gender.MALE,false);
        RegisterResult resultAlive = registry.registerVoter(Person3);
        Assert.assertEquals(RegisterResult.DEAD, resultAlive);

        Person Person4 = new Person("Daniela", 123456789, 17,Gender.FEMALE,true);
        RegisterResult resultUnderAge = registry.registerVoter(Person4);
        Assert.assertEquals(RegisterResult.UNDERAGE, resultUnderAge);

        Person Persona5 = new Person("Daniela", 123456789, 0,Gender.FEMALE,true);
        RegisterResult resultInvalidAge1 = registry.registerVoter(Persona5);
        Assert.assertEquals(RegisterResult.INVALID_AGE, resultInvalidAge1);
        Person person5 = new Person("Danielita", 1234567890, 121,Gender.FEMALE,true);
        RegisterResult resultInvalidAge = registry.registerVoter(person5);
        Assert.assertEquals(RegisterResult.INVALID_AGE, resultInvalidAge);

        Person person6 = new Person("Danielitaaaa", 1234567891, 19,null,true);
        RegisterResult resultInvalidGender = registry.registerVoter(person6);
        Assert.assertEquals(RegisterResult.INVALID_GENDER, resultInvalidGender);
        Assert.assertEquals(RegisterResult.INVALID_AGE, resultInvalidAge);

        Person persona6 = new Person("Danielitaaaa", 1234567891, 19,Gender.UNIDENTIFIED,true);
        RegisterResult ResultValid = registry.registerVoter(persona6);
        Assert.assertEquals(RegisterResult.VALID, ResultValid);
    }
}
