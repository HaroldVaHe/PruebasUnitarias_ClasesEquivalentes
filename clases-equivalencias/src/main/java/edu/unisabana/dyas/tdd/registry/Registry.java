package edu.unisabana.dyas.tdd.registry;
import java.util.HashSet;
import java.util.Set;



public class Registry {
    private Set<Integer> registeredIds = new HashSet<>();

    public RegisterResult registerVoter(Person p) {
        if (p.getGender() != Gender.MALE && p.getGender() != Gender.FEMALE && p.getGender() != Gender.UNIDENTIFIED) {
            return RegisterResult.INVALID_GENDER;
        }
        if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;

        } else if (p.getAge() > 120) {
            return RegisterResult.INVALID_AGE;

        } else if (isDuplicatedId(p.getId())) {
            return RegisterResult.DUPLICATED;

        } else if (!p.isAlive()) {
            return RegisterResult.DEAD;

        } else {
            // Todo Validate person and return real result.
            registeredIds.add(p.getId());
            return RegisterResult.VALID;
        }
    }


        private boolean isDuplicatedId(int id) {
            // Check if the ID already exists in the set of registered IDs
        return registeredIds.contains(id);
    }
}