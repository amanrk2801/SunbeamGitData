function authorization(req, res, next) {
    if (req.url == '/user/signup' || req.url == '/user/signin')
        next()
    else {
        const token = req.headers.token
        if (token) {
            try {
                const payload = jwt.verify(token, config.secret)
                req.headers.id = payload.id
                next()
            } catch (error) {
                res.send(result.createErrorResult('Token is Invalid'))
            }
        }
        else
            res.send(result.createErrorResult('Token is Missing'))
    }
}
module.exports = authorization