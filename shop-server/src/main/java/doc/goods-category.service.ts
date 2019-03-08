export interface GoodsCategoryReqModel {
        // 主键
        id?:  number;
        // 上机分类的编号：0表示一级分类
        parentId?:  number;
        // 名称
        name?: string;
        // 分类级别：0->1级；1->2级
        level?:  number;
        // 分类下商品数量，统计得到
        productCount?:  number;
        // 单位
        productUnit?: string;
        // 是否显示在导航栏：0->不显示；1->显示
        navStatus?:  number;
        // 显示状态：0->不显示；1->显示
        showStatus?:  number;
        // 排序
        sort?:  number;
        // 图标
        icon?: string;
        // 关键词
        keywords?: string;
        // 描述
        description?: string;
        // 创建人
        dbCreateAuthor?: string;
        // 创建时间
        dbCreateTime?: Date;
        // 更新人
        dbUpdateAuthor?: string;
        // 更新时间
        dbUpdateTime?: Date;
}

##############################################################################################

import { Injectable, Injector } from '@angular/core';
import { HttpUtilNs, HttpUtilService } from '../infra/http/http-util.service';
import { Observable } from 'rxjs/Observable';
export namespace GoodsCategoryServiceNs {
    export interface UfastHttpResT<T> extends HttpUtilNs.UfastHttpResT<T> {
    }
    export class GoodsCategoryServiceClass {
        private http: HttpUtilService;
        private defaultConfig: HttpUtilNs.UfastHttpConfig;
        private barcodeFlagList: { value: number, label: string }[];
        private returnState: { value: number, label: string }[];
        constructor(private injector: Injector) {
            this.http = this.injector.get(HttpUtilService);
            this.defaultConfig = {
                gateway: HttpUtilNs.GatewayKey.Ss
            };
            this.barcodeFlagList = [
                { label: '否', value: 0 },
                { label: '是', value: 1 }
            ];
        }
        public getBarcodeList(): Observable<any> {
            return Observable.of(this.barcodeFlagList);
        }

        /**列表 */
        public getGoodsCategoryList(filter): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsCategory/list', filter, this.defaultConfig);
        }

        /**新增保存 */
        public addSaveGoodsCategory(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsCategory/save', data, this.defaultConfig);
        }
        /**新增提交 */
        public addSubmitGoodsCategory(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsCategory/submit', data, this.defaultConfig);
        }
        /**详情 */
        public getGoodsCategoryDetail(id: string): Observable<UfastHttpResT<any>> {
            return this.http.Get<UfastHttpResT<any>>('/goodsCategory/item', { id: id }, this.defaultConfig);
        }
        /**结单 */
        public finishGoodsCategory(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsCategory/endBill', data, this.defaultConfig);
        }
        /**删除 */
        public deletePurchaseOut(ids: any[]): Observable<UfastHttpResT<any>> {
            return this.http.Post('/goodsCategory/delete', ids, this.defaultConfig);
        }
    }
}

@Injectable()
export class GoodsCategoryService extends GoodsCategoryServiceNs.GoodsCategoryServiceClass {
    constructor(injector: Injector) {
        super(injector);
    }
}

###########################################################################################

