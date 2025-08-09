import axios from 'axios'
import { config } from '../config'

export async function getProducts() {
  try {
    const url = `${config.serverUrl}/product`
    const response = await axios.get(url)
    if (response.status == 200) {
      return response.data
    }
  } catch (ex) {
    console.log(`Exception: `, ex)
  }
}
