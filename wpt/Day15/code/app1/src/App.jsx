import React, { useEffect, useState } from 'react'
import { uploadImage as uploadImageFromServer } from './services/imageDemo'

function App() {
  const [file, setFile] = useState(null)
  const [image, setImage] = useState(null)

  useEffect(() => {
    if (file) {
      console.log(URL)
      // loads the contents of the file in memory
      // which can be rendered by <img />
      const image = URL.createObjectURL(file)
      setImage(image)
    }
  }, [file])

  const uploadImage = async () => {
    const result = await uploadImageFromServer(file)
    console.log(result)
  }

  return (
    <div>
      <div>
        <label htmlFor=''>Select Image</label>
      </div>
      <div>
        <input
          multiple={false}
          onChange={(e) => {
            console.log(e.target.files)
            setFile(e.target.files[0])
          }}
          type='file'
          accept='image/*'
        />
      </div>
      <div>
        {image && (
          <img
            src={image}
            alt=''
            style={{ width: 200 }}
          />
        )}
      </div>
      <div>
        <button onClick={uploadImage}>upload</button>
      </div>
    </div>
  )
}

export default App
