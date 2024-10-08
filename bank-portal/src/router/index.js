import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginView from "@/views/LoginView.vue";
import MainView from "@/views/MainView.vue";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'LoginView',
        component: LoginView,
        prop: true,
    },
    {
        path: '/main',
        name: 'MainView',
        component: MainView,
        prop: true,
        children: [
            {path: 'user', name: 'UserView', component: () => import('@/views/UserView.vue'),prop: true},
            {path: 'transfer', name: 'TransferView', component: () => import('@/views/TransferView.vue'),prop: true},
            {path: 'deposit',name: 'DepositView', component: () => import('@/views/DepositView.vue'),prop: true}
        ]
    }
]

const router = new VueRouter({
    routes
})

export default router
