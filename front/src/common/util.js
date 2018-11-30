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

export default {
  contains: contains,
  removeElement: removeElement
}
