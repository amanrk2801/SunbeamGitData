function Person(props) {
  console.log(`props: `, props)
  return (
    <div>
      <div>name: {props['name']}</div>
      <div>address: {props['address']}</div>
      <div>profession: {props['profession']}</div>
    </div>
  )
}

export default Person
