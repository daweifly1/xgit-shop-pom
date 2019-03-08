export interface GoodsBrandReqModel {
        // pk
        id?:  number;
        // 品牌名称
        name?: string;
        // 首字母
        firstLetter?: string;
        // 排序
        sort?:  number;
        // 是否为品牌制造商：0->不是；1->是
        factoryStatus?:  number;
        // 展示状态，0否1是
        showStatus?:  number;
        // 产品数量
        productCount?:  number;
        // 产品评论数量
        productCommentCount?:  number;
        // 品牌logo
        logo?: string;
        // 专区大图
        bigPic?: string;
        // 品牌故事
        brandStory?: string;
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
export namespace GoodsBrandServiceNs {
    export interface UfastHttpResT<T> extends HttpUtilNs.UfastHttpResT<T> {
    }
    export class GoodsBrandServiceClass {
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
        public getGoodsBrandList(filter): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsBrand/list', filter, this.defaultConfig);
        }

        /**新增保存 */
        public addSaveGoodsBrand(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsBrand/save', data, this.defaultConfig);
        }
        /**新增提交 */
        public addSubmitGoodsBrand(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsBrand/submit', data, this.defaultConfig);
        }
        /**详情 */
        public getGoodsBrandDetail(id: string): Observable<UfastHttpResT<any>> {
            return this.http.Get<UfastHttpResT<any>>('/goodsBrand/item', { id: id }, this.defaultConfig);
        }
        /**结单 */
        public finishGoodsBrand(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsBrand/endBill', data, this.defaultConfig);
        }
        /**删除 */
        public deletePurchaseOut(ids: any[]): Observable<UfastHttpResT<any>> {
            return this.http.Post('/goodsBrand/delete', ids, this.defaultConfig);
        }
    }
}

@Injectable()
export class GoodsBrandService extends GoodsBrandServiceNs.GoodsBrandServiceClass {
    constructor(injector: Injector) {
        super(injector);
    }
}

###########################################################################################

