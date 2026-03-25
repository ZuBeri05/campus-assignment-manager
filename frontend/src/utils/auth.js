export const getToken = () => localStorage.getItem('token')
export const setToken = (t) => localStorage.setItem('token', t)
export const clearToken = () => localStorage.removeItem('token')

export const parseJwt = (token) => {
  try {
    const base64Url = token.split('.')[1]
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/')
    const jsonPayload = decodeURIComponent(atob(base64).split('').map(c => '%'+('00'+c.charCodeAt(0).toString(16)).slice(-2)).join(''))
    return JSON.parse(jsonPayload)
  } catch (e) {
    return null
  }
}

export const getRoles = () => {
  const token = getToken()
  if (!token) return []
  const payload = parseJwt(token)
  return payload?.roles || []
}

export const hasRole = (role) => getRoles().includes(role)
export const isLoggedIn = () => !!getToken()
