function Car(props) {
  // object destructuring
  const { model, company } = props

  return (
    <div>
      <div>Model: {model}</div>
      <div>Company: {company} </div>
    </div>
  )
}

export const num = 100

export default Car
