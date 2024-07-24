import {getCurrentInstance} from 'vue'
const useAxios=()=>{
    const instance=getCurrentInstance()
    console.log(3333,instance)
    const axios=instance?.appContext.config.globalProperties.$axios
    return axios
}

export default useAxios