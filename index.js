import { Client, Intents } from 'discord.js'
/**TODO: 
 * Next session
 * Create a Config component
 */
import 'dotenv/config'

const client =  new Client({ intents: [Intents.FLAGS.GUILDS] })

client.on('ready', () => {
  console.log("Bot is Running...")
})

client.login(process.env.DISCORD_TOKEN)
