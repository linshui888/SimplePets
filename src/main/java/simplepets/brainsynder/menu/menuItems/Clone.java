package simplepets.brainsynder.menu.menuItems;

import org.bukkit.Material;
import simplepets.brainsynder.api.entity.IEntityPet;
import simplepets.brainsynder.api.entity.ambient.IEntityArmorStandPet;
import simplepets.brainsynder.menu.menuItems.base.MenuItemAbstract;
import simplepets.brainsynder.pet.PetDefault;
import simplepets.brainsynder.utils.ItemBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clone extends MenuItemAbstract {

    public Clone(PetDefault type, IEntityPet entityPet) {
        super(type, entityPet);
    }
    public Clone(PetDefault type) {
        super(type);
    }

    @Override
    public ItemBuilder getItem() {
        ItemBuilder item = type.getDataItemByName("clone", 0);
        if (item != null) {
            if (entityPet instanceof IEntityArmorStandPet) {
                IEntityArmorStandPet var = (IEntityArmorStandPet) entityPet;
                item.withName(String.valueOf(item.toJSON().get("name"))
                .replace("%value%", String.valueOf(var.isOwner())));
            }
        }
        return item;
    }

    @Override
    public List<ItemBuilder> getDefaultItems() {
        ItemBuilder item = new ItemBuilder(Material.SKULL_ITEM);
        item.withData(3);
        item.withName("&6IsClone: &e%value%");
        return new ArrayList<>(Collections.singleton(item));
    }

    @Override
    public void onLeftClick() {
        if (entityPet instanceof IEntityArmorStandPet) {
            IEntityArmorStandPet bat = (IEntityArmorStandPet) entityPet;
            if (bat.isOwner()) {
                bat.setOwner(false);
            } else {
                bat.setOwner(true);
            }
        }
    }
}