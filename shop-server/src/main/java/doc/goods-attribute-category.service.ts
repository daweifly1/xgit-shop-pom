export interface GoodsAttributeCategoryReqModel {
        // 主键
        id?:  number;
        // 名称
        name?: string;
        // 属性数量
        attributeCount?:  number;
        // 参数数量
        paramCount?:  number;
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
export namespace GoodsAttributeCategoryServiceNs {
    export interface UfastHttpResT<T> extends HttpUtilNs.UfastHttpResT<T> {
    }
    export class GoodsAttributeCategoryServiceClass {
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
        public getGoodsAttributeCategoryList(filter): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttributeCategory/list', filter, this.defaultConfig);
        }

        /**新增保存 */
        public addSaveGoodsAttributeCategory(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttributeCategory/save', data, this.defaultConfig);
        }
        /**新增提交 */
        public addSubmitGoodsAttributeCategory(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttributeCategory/submit', data, this.defaultConfig);
        }
        /**详情 */
        public getGoodsAttributeCategoryDetail(id: string): Observable<UfastHttpResT<any>> {
            return this.http.Get<UfastHttpResT<any>>('/goodsAttributeCategory/item', { id: id }, this.defaultConfig);
        }
        /**结单 */
        public finishGoodsAttributeCategory(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttributeCategory/endBill', data, this.defaultConfig);
        }
        /**删除 */
        public deletePurchaseOut(ids: any[]): Observable<UfastHttpResT<any>> {
            return this.http.Post('/goodsAttributeCategory/delete', ids, this.defaultConfig);
        }
    }
}

@Injectable()
export class GoodsAttributeCategoryService extends GoodsAttributeCategoryServiceNs.GoodsAttributeCategoryServiceClass {
    constructor(injector: Injector) {
        super(injector);
    }
}

###########################################################################################

