package me.clanky.anticlient;

import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

public class EntityGetter extends JavaPlugin {
    public static EntityType getEntity(String par1){
    	if(par1.equalsIgnoreCase("creeper") || par1.equalsIgnoreCase("failpig") || par1.equalsIgnoreCase("drygreenleaf")){
    		return EntityType.CREEPER;
    	}else if(par1.equalsIgnoreCase("pig")){
    		return EntityType.PIG;
    	}else if(par1.equalsIgnoreCase("sheep")){
    		return EntityType.SHEEP;
    	}else if(par1.equalsIgnoreCase("cow")){
    		return EntityType.COW;
    	}else if(par1.equalsIgnoreCase("blaze")){
    		return EntityType.BLAZE;
    	}else if(par1.equalsIgnoreCase("cavespider")){
    		return EntityType.CAVE_SPIDER;
    	}else if(par1.equalsIgnoreCase("spider")){
    		return EntityType.SPIDER;
    	}else if(par1.equalsIgnoreCase("skeleton")){
    		return EntityType.SKELETON;
    	}else if(par1.equalsIgnoreCase("zombie")){
    		return EntityType.ZOMBIE;
    	}else if(par1.equalsIgnoreCase("giant")){
    		return EntityType.GIANT;
    	}else if(par1.equalsIgnoreCase("enderman")){
    		return EntityType.ENDERMAN;
    	}else if(par1.equalsIgnoreCase("ghast")){
    		return EntityType.GHAST;
    	}else if(par1.equalsIgnoreCase("horse")){
    		return EntityType.HORSE;
    	}else if(par1.equalsIgnoreCase("irongolem")){
    		return EntityType.IRON_GOLEM;
    	}else if(par1.equalsIgnoreCase("mooshroom") || par1.equalsIgnoreCase("mushroomcow")){
    		return EntityType.MUSHROOM_COW;
    	}else if(par1.equalsIgnoreCase("ocelot") || par1.equalsIgnoreCase("cat")){
    		return EntityType.OCELOT;
    	}else if(par1.equalsIgnoreCase("zombiepig") || par1.toLowerCase().contains("pigman")){
    		return EntityType.PIG_ZOMBIE;
    	}else if(par1.equalsIgnoreCase("silverfish")){
    		return EntityType.SILVERFISH;
    	}else if(par1.equalsIgnoreCase("enderdragon")){
    		return EntityType.ENDER_DRAGON;
    	}else if(par1.equalsIgnoreCase("wither")){
    		return EntityType.WITHER;
    	}else if(par1.equalsIgnoreCase("slime")){
    		return EntityType.SLIME;
    	}else if(par1.equalsIgnoreCase("snowman") || par1.equalsIgnoreCase("snowgolem")){
    		return EntityType.SNOWMAN;
    	}else if(par1.equalsIgnoreCase("squid")){
    		return EntityType.SQUID;
    	}else if(par1.equalsIgnoreCase("bat")){
    		return EntityType.BAT;
    	}else if(par1.equalsIgnoreCase("villager")){
    		return EntityType.VILLAGER;
    	}else if(par1.equalsIgnoreCase("witch")){
    		return EntityType.WITCH;
    	}else if(par1.equalsIgnoreCase("wolf") || par1.equalsIgnoreCase("dog")){
    		return EntityType.WOLF;
    	}else{
    		return EntityType.UNKNOWN;
    	}
    }
}
