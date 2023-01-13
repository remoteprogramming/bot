import { SapphireClient } from '@sapphire/framework'
/**TODO: 
 * Next session
 * Create a Config component
 */
import 'dotenv/config'

const client = new SapphireClient({ intents: [GatewayIntentBits.Guilds] });

client.on('ready', () => {
  console.log("Bot is Running...")
})

client.login(process.env.DISCORD_TOKEN)
