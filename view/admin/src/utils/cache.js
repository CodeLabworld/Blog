export function set(key, value) {
  window.localStorage.setItem("xihua_" + key, value);
}

export function get(key) {
  return window.localStorage.getItem("xihua_" + key);
}

export function remove(key) {
  window.localStorage.removeItem("xihua_" + key);
}