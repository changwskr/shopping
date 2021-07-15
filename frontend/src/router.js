
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/OrderManager"

import ShippingManager from "./components/ShippingManager"

import InventoryManager from "./components/InventoryManager"


import MyPage from "./components/MyPage"
export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },

            {
                path: '/shippings',
                name: 'ShippingManager',
                component: ShippingManager
            },

            {
                path: '/inventories',
                name: 'InventoryManager',
                component: InventoryManager
            },


            {
                path: '/myPages',
                name: 'MyPage',
                component: MyPage
            },


    ]
})
