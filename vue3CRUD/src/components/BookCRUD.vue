<template>
  <el-button type="primary" size="small" @click="handleAdd">
    新增
  </el-button>
  <el-table :data="tableData" :border="true" style="width: 100%">
    <el-table-column prop="id" label="Date" width="180" />
    <el-table-column prop="name" label="Name" width="180" />
    <el-table-column prop="author" label="Author" />
    <el-table-column fixed="right" label="Operations" width="200">
      <template #default="{ row }">
        <el-button link type="primary" size="small" @click="handleView(row)">
          查看
        </el-button>
        <el-button link type="primary" size="small" @click="handleEdit(row)">编辑</el-button>
        <el-button link type="primary" size="small" @click="handleDelete(row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-dialog v-model="dialogFormVisible" :title="title" width="500">
    <el-form :model="form">
      <el-form-item label="type" :label-width="formLabelWidth">
        <el-input v-model="form.type" autocomplete="true" :disable="dialogType == 'view'" />
      </el-form-item>
      <el-form-item label="name" :label-width="formLabelWidth">
        <el-input v-model="form.name" autocomplete="off" :disable="dialogType == 'view'" />
      </el-form-item>
      <el-form-item label="description" :label-width="formLabelWidth">
        <el-input v-model="form.description" autocomplete="off" :disable="dialogType == 'view'" />
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="handleSubmit">
          Confirm
        </el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script setup>
import { ref } from 'vue'
import useAxios from '@/utils/useAxios.js';
import { ElMessage } from 'element-plus'

const tableData = ref([])
const dialogFormVisible = ref(false)
const formLabelWidth = ref('120px')
const form = ref({})
const title = ref('Add Book')
const dialogType = ref('add')
const axios = useAxios()


const handleAdd = () => {
  title.value = 'Add Book'
  dialogType.value = 'add'
  form.value = {
    type: '',
    name: '',
    description: '',
  }
  dialogFormVisible.value = true
}
const handleView = (row) => {
  title.value = 'View Book'
  dialogType.value = 'view'
  form.value = row
  dialogFormVisible.value = true
}
const handleEdit = (row) => {
  title.value = 'Edit Book'
  dialogType.value = 'edit'
  form.value = row
  dialogFormVisible.value = true
}
const handleDelete = (row) => {
  dialogType.value = 'delete'
  form.value = row
}
const handleSubmit = () => {
  if (dialogType.value == 'add') {
    fnAdd()
  } else if (dialogType.value === 'edit') {
    fnUpdate()
  }
}

const fnAdd = () => {
console.log(222,form.value)
  axios.post('/api/books', {
    data: form.value
  }).then((res) => {
    ElMessage({
      message: '保存成功',
      type: 'success',
    })
    getList()
    dialogFormVisible.value = false
  }).catch((err) => {
    console.log('保存', err)
  })
}
const fnUpdate = () => {
  axios.put('/api/books', {
    data: form
  }).then((res) => {
    ElMessage({
      message: '更新成功',
      type: 'success',
    })
    getList()
    dialogFormVisible.value = false
  }).catch((err) => {
    console.log('更新', err)
  })
}
const fnView = () => {
  axios.get(`/api/books/${form.value?.id}`).then((res) => {
    form.value = res
  }).catch((err) => {
    console.log('删除', err)
  })
}
const fnDelete = () => {
  axios.delete(`/api/books/${form.value?.id}`).then((res) => {
    ElMessage({
      message: '删除成功',
      type: 'success',
    })
    getList()
  }).catch((err) => {
    console.log('删除', err)
  })
}

// created
const getList = () => {
  axios.get('/api/books').then((res) => {
    console.log(1111,res)
    tableData.value = res.data || []
  }).catch((err) => {
    console.log('获取列表', err)
  })
}
getList()
</script>

<style></style>
