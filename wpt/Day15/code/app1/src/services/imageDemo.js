import axios from 'axios'

export async function uploadImage(image) {
  try {
    const url = 'http://localhost:4000/image'
    const body = new FormData()
    body.append('photo', image)

    console.log(body)
    const response = await axios.post(url, body)
    if (response.status == 200) {
      return response.data
    } else {
      console.log('error')
    }
  } catch (ex) {
    console.log(`exception: `, ex)
  }
}
