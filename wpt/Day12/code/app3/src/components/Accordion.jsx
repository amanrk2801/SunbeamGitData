import { useState } from 'react'
import './Accordion.css'

function Accordion() {
  const [isVisible, setIsVisible] = useState(true)

  const onToggle = () => {
    setIsVisible(!isVisible)
  }

  return (
    <div>
      <h2>Accordion</h2>
      <div className='title'>
        <span>Title of the accordion</span>
        <button onClick={onToggle}>toggle</button>
      </div>

      {/* conditional rendering */}
      {isVisible && (
        <div className='body'>
          Lorem ipsum dolor sit amet consectetur, adipisicing elit. Nesciunt
          placeat dolor quod, at aspernatur blanditiis corrupti vitae dolorem
          iusto fugiat enim exercitationem cumque recusandae nostrum cum nam rem
          aliquid. Veritatis. Lorem ipsum, dolor sit amet consectetur
          adipisicing elit. Recusandae, voluptatem repellendus, cum tenetur
          eaque sint voluptatum sequi harum maxime molestias, nostrum molestiae?
          Incidunt voluptates ipsam minus atque molestias officiis dolor!
        </div>
      )}
    </div>
  )
}

export default Accordion
