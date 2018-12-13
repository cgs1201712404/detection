/**
 \* Created with IntelliJ IDEA.
 \* User: 彭诗杰
 \* Date: 2018/8/3 10:23
 \* Description: 工具类
 \*/

function contains(holder, str) {
  return holder.indexOf(str) !== -1;
}

/**
 * 从指定数组中通过指定属性删除对应元素
 * @param list 待遍历的数组
 * @param entity
 * @param attr
 */
function removeElement(list, entity, attr) {
  for (let index = 0; index <= list.length; index++) {
    if (entity[attr] === list[index][attr]) {
      list.splice(index, 1);
    }
  }
}

function deepCopy(obj) {
  if (typeof obj !== 'object') {
    return obj;
  }
  let newobj = {};
  for (let attr in obj) {
    if (attr !== null) {
      newobj[attr] = deepCopy(obj[attr]);
    }
  }
  return newobj;
}

/**
 * 设置权限组中checked属性
 * @param permissionGroup 权限组list
 * @param value true or false
 */
function setPermissionGroupChecked(permissionGroup, value) {
  for (let menuPermission of permissionGroup) {
    menuPermission.checked = value;
    if (contains(Object.getOwnPropertyNames(menuPermission), 'permission')) {
      for (let dataPermission of menuPermission.permission) {
        dataPermission.checked = value
      }
    }
  }
}

export default {
  contains: contains,
  removeElement: removeElement,
  copyObject: deepCopy,
  setPermissionGroupChecked: setPermissionGroupChecked
}
