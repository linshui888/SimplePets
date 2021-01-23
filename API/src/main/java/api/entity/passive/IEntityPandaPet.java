package api.entity.passive;

import simplepets.brainsynder.api.entity.misc.EntityPetType;
import simplepets.brainsynder.api.entity.misc.IAgeablePet;
import simplepets.brainsynder.api.entity.misc.ISpecialFlag;
import simplepets.brainsynder.api.pet.PetType;
import simplepets.brainsynder.api.wrappers.PandaGene;

@EntityPetType(petType = PetType.PANDA)
public interface IEntityPandaPet extends IAgeablePet, ISpecialFlag {

    PandaGene getGene ();
    void setGene (PandaGene gene);

    void setSitting(boolean value);
    boolean isSitting();

    void setSneezing (boolean value);
    default boolean isSneezing() {
        return getSpecialFlag(2);
    }

    default boolean isScared() {
        return getSpecialFlag(8);
    }
    default void setScared(boolean value) {
        setSpecialFlag(8, value);
    }

    default boolean isPlaying() {
        return getSpecialFlag(4);
    }
    default void setPlaying(boolean value) {
        setSpecialFlag(4, value);
    }

    default boolean isLyingOnBack() {
        return getSpecialFlag(16);
    }
    default void setLyingOnBack(boolean value) {
        setSpecialFlag(16, value);
    }

}