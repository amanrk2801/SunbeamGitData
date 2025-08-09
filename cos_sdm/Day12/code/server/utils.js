function createResult(data, error) {
  if (error) {
    return createError(error)
  } else {
    return createSuccess(data)
  }
}

function createSuccess(data) {
  return { status: 'success', data }
}

function createError(error) {
  return { status: 'error', error }
}

module.exports = {
  createResult,
  createSuccess,
  createError,
}
